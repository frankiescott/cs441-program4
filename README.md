# cs441-program4

This application has two activities: the first utilizing the RecyclerView widget with a floating action button the user can click to continually add Pokemon to the RecylerView, and the second displaying a line on a graph with two sliders to control the slope and y-intercept value of the line. The user can click the "Double B" button which sends a post request to a webserver that doubles the current value and updates the line on the graph to reflect the new value.

I started by implementing the Professor's example code for the RecyclerView, but instead of statically added items to the RecyclerView in the `onCreate()` method, I linked the add item process to a floating action button that pulls Pokemon sequentially to populate the list as the user presses the button. Finally, I added a button to swap to the second activity.

I started the second activity by implementing the user interface: the `m` slider and the `b` slider to control the values in the equation `y = mx + b` I then created a custom `DrawView` class that extends `View` in order to override the `onDraw()` method so I could draw a line with specific dimensions within the custom view. I set up different `Paint` objects so I could draw the axes, tick marks on each axis, and a grid within the class. Once I had the graph properly drawn, I was able to link the control sliders to the line drawn on the graph so the user can adjust the dimensions of the line.

Lastly, I implemented the Professor's code to allow for an HTTP POST request that sends the current `b` value to a webserver that responds with a json object containing the doubled value. Once the value was doubled and retrieved, I made the graph update so the user can view the changes of the line dimensions.

# Development Schedule

June 30th - Initialized project and implemented RecyclerView class

July 2nd - Added floating action button to append Pokemon to the RecyclerView list

July 4th - Expanded the project with a second activity and designed the user interface of the graph control

July 6th - Created the custom `DrawView` class that extends `View` to begin line drawing

July 7th - Overrode the `onMeasure()` method so the DrawView fits properly within the activity

July 8th - Worked on drawing the line with dynamic `m` and `b` values linked to the user interface sliders

July 10th - Created a button to doulbe the `b` value of the line by sending a POST request to a webserver  

 