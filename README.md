# SwipeToReveal

A swipe to reveal helper for RecyclerViews

* Written in Kotlin with :heart:
* Min SDK 21
* AndroidX ready


![gif](https://github.com/j-roskopf/SwipeToReveal/blob/master/gifs/swipe.gif?raw=true)

# Dependencies

    build.gradle

    allprojects {
    	repositories {
    		...
    		maven { url 'https://jitpack.io' }
    	}
    }

    app/build.gradle

	dependencies {
	    implementation 'com.github.j-roskopf:SwipeToReveal:1.0'
	}

# Code Example

See sample application

    val swipeToLeftCallback = object : SwipeToLeftCallback(this, R.drawable.drawable_icon, R.color.background_color) {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // react to swipe
        }
    }
    val swipeToLeftItemTouchHelper = ItemTouchHelper(swipeToLeftCallback)
    swipeToLeftItemTouchHelper.attachToRecyclerView(recyclerView)
    
    val swipeToRightCallback = object : SwipeToRightCallback(this, R.drawable.drawable_icon, R.color.background_color) {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // react to swipe
        }
    }
    val swipeToRightItemTouchHelper = ItemTouchHelper(swipeToRightCallback)
    swipeToRightItemTouchHelper.attachToRecyclerView(recyclerView)
