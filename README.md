# Music Visualiser Project

Name: Joyal Jose

Student Number: C22756115

<!-- ## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet -->

# Description

This project uses the Processing graphics library and Minim audio library in java to create a set of music visuals for the songs "Am I Dreaming" and "Spot Holes 2 - Epic Version" from the movie "Spider-Man: Across The Spider-Verse".
It implements 4 scenes that try to capture the themes and feelings from the movie.
<details>
<summary>Disclaimer</summary>
<br>
Note: None of the music and images used in this project are my own and all credit goes to their respective owners.
</details>

# Instructions

Scene Selection;
-Select scene using number keys: 0 -> 3
-(Recommended order is 0 -> 2 -> 3 -> 1 (with Spot theme song))

Media Controls;
-Play/Pause: Spacebar
-Seek forwards 5s: Right arrow
-Seek backwards 5s: Left arrow
-Rewind song: Backspace
-Change song: Enter

# How it works

We use an abstract class Visual (subclass of PApplet) that implements most of the audio processing using the Minim audio library that uses the JavaSoundAPI. This class implements things like;
- Loading, playing and pausing the audio file
- Calculating the average amplitude of the audio buffer
- Using linear interpolation to smooth the audio buffer values
This abstract class is extended by the JoyalsVisual class which is the main control class of the project. It implements;
- keyPressed function for media controls
- settings() & setup() which run once at the start of execution
- draw() which runs once per frame: This function is responsible for calling the render() of each scene based on user input

Progress Bar;
- Calculates how much of the song has been played with "getAudioPlayer().position() / trackLength" and draws a progrss bar using line() at the top of the screen

Scene 0 - Top waveform, Spiderman logo, Rain animation;
- The top waveform is created by drawing lines proportional to the value of the lerped audio buffer at the screen
- The spiderman logo is rendered using PImage and its size is mapped by the value of the average amplitude of the audio buffer
- The rain animation is created by the Rain class which creates an array of Raindrop objects. The Rain class renders the falling animation of the raindrops, their splash effect and resets their position once they go offscreen
- The Raindrop class implements the falling logic for each raindrop, that makes it fall faster/slower depending on its length

Scene 2 - Boids simulation;
- This scene uses two classes Boid and Flock to create a simulation of Boid objects (stored in an ArrayList) that mimic the flocking behaviour of birds or fish in nature.
- The simulation is made up of 3 main components:
	1. Seperate - This maintains seperation between the boids by steering away from nearby boids slightly
	2. Alignment - This steers the boids towards the average heading of nearby flockmates based on their velocity
	3. Cohesion - This calculates the average position of all nearby boids and steers towards that position
- These PVector forces are added together to get the acceleration which is then mapped based on the amplitude of the music. This causes the boids to move quickly in the more energetic parts of the song while slowing to almost a complete stop in more quiet parts.

Scene 3 - Waveform floor, hex portal rings;
- 

Scene 1 - Spot dimension;
- The central element is made up of a 3D sphere whose radius increases/decreases (and is mapped to a range of values) along with the amplitude of the music. It is surrounded by a circular waveform made up of a series of lines whose endpoints are calculated using polar coordinates. 

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

