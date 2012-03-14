# Tests with different rendering techniques

## How to run

Compile into a `bin` dir or something alike.

	cd bin
	java main.Main <rendering-method>

where `rendering-method` is "m1", "m2", etc. Check `core.ViewController`. Current FPS will be shown in the graphics context and in the system prompt.

## Add a new renderer

1. Create a new renderer class that implements `gui.Renderer`.
2. Override the `render()` method.
3. Initialize the instance variable `renderer`in `core.ViewController` to your new renderer in constructor.