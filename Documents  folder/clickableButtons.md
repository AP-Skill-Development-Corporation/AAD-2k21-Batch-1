# Android Images and ClickableImages 

* For an Android app, user interaction typically involves tapping, typing, using gestures, or talking. The Android framework provides corresponding user interface (UI) elements such as buttons, clickable images, menus, keyboards, text entry fields, and a microphone.

* When designing an interactive app, make sure your app is intuitive; that is, your app should perform as your users expect it to perform. For example, when you rent a car, you expect the steering wheel, gear shift, headlights, and indicators to be in a certain place. Another example is that when you first enter a room, you expect the light switch to be in a certain place. Similarly, when a user starts an app, the user expects buttons and images to be clickable. Don't violate established expectations, or you'll make it harder for your users to use your app.

* Note: Android users expect UI elements to act in certain ways, so it's important that your app be consistent with other Android apps. To satisfy your users, create a layout that gives users predictable choices.

#### Designing buttons

* People like to press buttons. Show someone a big red button with a message that says "Do not press" and the person will probably press the button, just for the pleasure of pressing a big red button. (That the button is forbidden is also a factor.)

* You use the Button class to make a button for an Android app. Buttons can have the following design:

  * Text only, as shown on the left side of the figure below.
  * Icon only, as shown in the center of the figure below.
  * Both text and an icon, as shown on the right side of the figure below
  <img src="https://github.com/Muneiahtellakula/android_development/blob/master/btn.png?raw=true">
* When the user touches or clicks a button, the button performs an action. The button's text or icon should provide a hint about what that action will be. (Buttons are sometimes called "push-buttons" in Android documentation.)

* A button is usually a rectangle or rounded rectangle with a descriptive caption or icon in its center. Android Button elements follow the guidelines in the Android Material Design specification. (You learn more about Material Design in another lesson.)

* Android offers several types of Button elements, including raised buttons and flat buttons as shown in the figure below. Each button has three states: normal, disabled, and pressed.

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/btn_apper.png?raw=true">

**In the figure above:**

  1. Raised button in three states: normal, disabled, and pressed
  2. Flat button in three states: normal, disabled, and pressed

**Creating a raised button with an icon and text**

* While a Button usually displays text that tells the user what the action is, a raised Button can also display an icon along with text.


**Choosing an icon**

**To choose images of a standard icon that are resized for different displays, follow these steps:**

  1. Expand app > res in the Project > Android pane, and right-click (or Command-click) the drawable folder.
  2. Choose New > Image Asset. The Configure Image Asset dialog appears.
  
   <img src="https://github.com/Muneiahtellakula/android_development/blob/master/as_configure_image_asset_01.png?raw=true" height=400 width=600>
  
  3. Choose Action Bar and Tab Icons in the drop-down menu. (For a complete description of this dialog, see Create app icons with Image Asset Studio.)
  4. Click the Clipart: image (the Android logo) to select a clip art image as the icon. A page of icons appears as shown below. Click the icon you want to use.
      
      <img src="https://github.com/Muneiahtellakula/android_development/blob/master/as_configure_image_asset_02.png?raw=true" height=400 width=600>
  5. Optional: Choose HOLO_DARK from the Theme drop-down menu to set the icon to be white against a dark-colored or black background.

  6. Optional: Depending on the shape of the icon, you may want to add padding to the icon so that the icon doesn't crowd the text. Drag the Padding slider to the right to add more padding.
  7. Click Next, and then click Finish in the Confirm Icon Path dialog. The icon name should now appear in the app > res > drawable folder.
  
   **Vector images of a standard icon are automatically resized for different sizes of device displays. To choose vector images, follow these steps:**

  1. Expand app > res in the Project > Android pane, and right-click (or Command-click) the drawable folder.
  2. Choose New > Vector Asset for an icon that automatically resizes itself for each display.
  3. The Vector Asset Studio dialog appears for a vector asset. Click the Material Icon radio button, and then click the Choose button to choose an icon from the Material    Design specification. (For a complete description of this dialog, see Add Multi-Density Vector Graphics.)
  4. Click Next after choosing an icon, and click Finish to finish. The icon name should now appear in the app > res > drawable folder.
#### Sample example

**Here,Screen 1 : have Android Icon symbol is ImageView and rightmark is ImageButton .when it initial  time shows the black color**

**Screen 2 : when click the ImageButton and Imageview It will change the Green color.If you click both then it shown like colors Screen 3**

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/img_btn_normal.PNG?raw=true">



#### Project Directory files information following 

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/pjtFiles.PNG?raw=true">

**acivity_main.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="top"
    tools:context=".MainActivity">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="400dp"
        android:id="@+id/image"
        android:src="@drawable/ic_android_black_24dp"
       />
    <ImageButton
        android:layout_width="300dp"
        android:layout_height="300dp"
        android:id="@+id/img_btn"
        android:layout_gravity="center"
        android:background="#fff"
        android:layout_margin="20dp"
        android:src="@drawable/ic_check_black_24dp"
        />

</LinearLayout>
```
**button_actions.xml** new drawable resource file
```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/ic_android_green_24dp"
        android:state_pressed="true" />
    <item android:drawable="@drawable/ic_android_blue_24dp"
        android:state_window_focused="true" />
    <item android:drawable="@drawable/ic_android_black_24dp" />
</selector>

```
**MainActivity.java**

```
package com.muneiah.imagebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
ImageView iv;
ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.image);
        ib=findViewById(R.id.img_btn);

        /*Imageview Clickable Event Handling */
        iv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            iv.setImageResource(R.drawable.button_actions);
                Toast.makeText(MainActivity.this, "Hello, I'm ImageView", Toast.LENGTH_SHORT).show();

            }
        });
        /*ImageButton  Clickable Event Handling */
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib.setImageResource(R.drawable.button_actions);
                Toast.makeText(MainActivity.this, "You clicked Image Button", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

```
