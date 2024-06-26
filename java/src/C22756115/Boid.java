/* See "Steering Behaviors For Autonomous Characters" by Craig Reynolds
    -> Combined Behaviours and Groups
        -> Flocking
*/

package C22756115;

import java.util.ArrayList;

import processing.core.*;

class Boid {
    JoyalsVisual jv;

    PVector position;
    PVector velocity;
    PVector acceleration;
    float r;
    float maxforce; // Maximum steering force
    float maxspeed; // Maximum speed    

    Boid (float x, float y, JoyalsVisual jv)
    {
        this.jv = jv;

        acceleration = new PVector(0, 0);
        float angle = jv.random(PConstants.TWO_PI);
        velocity = new PVector(PApplet.cos(angle), PApplet.sin(angle));

        position = new PVector(x, y);
        r = 2.0f;
        maxspeed = 2;
        maxforce = 0.03f;
    }

    // void run(ArrayList<Boid> boids) {
    //     flock(boids);
    //     update();
    //     borders();
    //     render();
    // }

    void run(ArrayList<Boid> boids) {
        float amplitude = jv.getSmoothedAmplitude();
    
        // Map the amplitude to adjust speed within a suitable range
        float minAmp = 0.01f; // Minimum amplitude
        float maxAmp = 1.0f;  // Maximum amplitude
        float minSpeed = 0.0f; // Minimum speed
        float maxSpeed = 35.0f; // Maximum speed
        float mappedSpeed = PApplet.map(amplitude, minAmp, maxAmp, minSpeed, maxSpeed);
    
        // Update maxspeed based on the mapped amplitude
        maxspeed = mappedSpeed;
    
        flock(boids);
        update();
        borders();
        render();
    }

    void applyForce(PVector force) {
        acceleration.add(force);
    }

    // We accumulate a new acceleration each time based on three rules
    void flock(ArrayList<Boid> boids) {
        PVector sep = separate(boids); // Separation
        PVector ali = align(boids); // Alignment
        PVector coh = cohesion(boids); // Cohesion
        // Arbitrarily weight these forces
        sep.mult(1.5f);
        ali.mult(1.0f);
        coh.mult(1.0f);
        // Add the force vectors to acceleration
        applyForce(sep);
        applyForce(ali);
        applyForce(coh);
    }

    // Method to update position
    void update() {
        // Update velocity
        velocity.add(acceleration);
        // Limit speed
        velocity.limit(maxspeed);
        position.add(velocity);
        // Reset accelertion to 0 each cycle
        acceleration.mult(0);
    }

    // A method that calculates and applies a steering force towards a target
    // STEER = DESIRED MINUS VELOCITY
    PVector seek(PVector target) {
        PVector desired = PVector.sub(target, position); // A vector pointing from the position to the target
        // Scale to maximum speed
        desired.normalize();
        desired.mult(maxspeed);

        // Steering = Desired minus Velocity
        PVector steer = PVector.sub(desired, velocity);
        steer.limit(maxforce); // Limit to maximum steering force
        return steer;
    }

    void render() {
        // Draw a triangle rotated in the direction of velocity
        float theta = velocity.heading() + PApplet.radians(90);

        jv.fill(200, 100);
        jv.stroke(242, 29, 68);
        jv.pushMatrix();
        jv.translate(position.x, position.y);
        jv.rotate(theta);
        jv.beginShape(PConstants.TRIANGLES);
        jv.vertex(0, -r * 2);
        jv.vertex(-r, r * 2);
        jv.vertex(r, r * 2);
        jv.endShape();
        jv.popMatrix();
    }

    // Wraparound
    void borders() {
        if (position.x < -r)
            position.x = jv.width + r;
        if (position.y < -r)
            position.y = jv.height + r;
        if (position.x > jv.width + r)
            position.x = -r;
        if (position.y > jv.height + r)
            position.y = -r;
    }

    // Separation
    // Method checks for nearby boids and steers away
    PVector separate(ArrayList<Boid> boids) {
        float desiredseparation = 25.0f;
        PVector steer = new PVector(0, 0, 0);
        int count = 0;
        // For every boid in the system, check if it's too close
        for (Boid other : boids) {
            float d = PVector.dist(position, other.position);
            // If the distance is greater than 0 and less than an arbitrary amount (0 when
            // you are yourself)
            if ((d > 0) && (d < desiredseparation)) {
                // Calculate vector pointing away from neighbor
                PVector diff = PVector.sub(position, other.position);
                diff.normalize();
                diff.div(d); // Weight by distance
                steer.add(diff);
                count++; // Keep track of how many
            }
        }
        // Average -- divide by how many
        if (count > 0) {
            steer.div((float) count);
        }

        // As long as the vector is greater than 0
        if (steer.mag() > 0) {
            // Implement Reynolds: Steering = Desired - Velocity
            steer.normalize();
            steer.mult(maxspeed);
            steer.sub(velocity);
            steer.limit(maxforce);
        }
        return steer;
    }

    // Alignment
    // For every nearby boid in the system, calculate the average velocity
    PVector align(ArrayList<Boid> boids) {
        float neighbordist = 50;
        PVector sum = new PVector(0, 0);
        int count = 0;
        for (Boid other : boids) {
            float d = PVector.dist(position, other.position);
            if ((d > 0) && (d < neighbordist)) {
                sum.add(other.velocity);
                count++;
            }
        }
        if (count > 0) {
            sum.div((float) count);

            // Implement Reynolds: Steering = Desired - Velocity
            sum.normalize();
            sum.mult(maxspeed);
            PVector steer = PVector.sub(sum, velocity);
            steer.limit(maxforce);
            return steer;
        } else {
            return new PVector(0, 0);
        }
    }

    // Cohesion
    // For the average position (i.e. center) of all nearby boids, calculate
    // steering vector towards that position
    PVector cohesion(ArrayList<Boid> boids) {
        float neighbordist = 50;
        PVector sum = new PVector(0, 0); // Start with empty vector to accumulate all positions
        int count = 0;
        for (Boid other : boids) {
            float d = PVector.dist(position, other.position);
            if ((d > 0) && (d < neighbordist)) {
                sum.add(other.position); // Add position
                count++;
            }
        }
        if (count > 0) {
            sum.div(count);
            return seek(sum); // Steer towards the position
        } else {
            return new PVector(0, 0);
        }
    }
}
