# Shared Elements Transitions

## Implementation
### Set `windowContentTransitions` to `true` on `styles.xml`
```
<item name="android:windowContentTransitions">true</item>
```
### Add `transitionName` to the corresponding layouts
```
android:transitionName="TRANSITION_NAME"
```
### Initialize ActivityOptionCompat
```
val optionsCompat = ViewCompat.getTransitionName(image_main)?.let { transitionName ->
  ActivityOptionsCompat.makeSceneTransitionAnimation(
      this,
      image_main,
      transitionName
  )
}
```
### Start the Activity
```
val intent = Intent(this, DetailsActivity::class.java)
startActivity(intent, optionsCompat?.toBundle())
```
### Remove white blinking between transitions (optional)
#### Add `windowActionBar` and `windowNoTitle` on `styles.xml` file
```
<item name="windowActionBar">false</item>
<item name="windowNoTitle">true</item>
```
#### Exclude fade target
```
val fade = Fade()
fade.excludeTarget(android.R.id.statusBarBackground, true)
fade.excludeTarget(android.R.id.navigationBarBackground, true)
```
### Add Explode() effect (optional)
```
window.enterTransition = Explode()
window.exitTransition = Explode()
```

## Multiple Shared Elements
```
import androidx.core.util.Pair

val p1 = Pair.create<View, String>(<ELEMENT_ID>, "<TRANSITION_NAME>")
...
...
val pN = Pair.create<View, String>(<ELEMENT_ID>, "<TRANSITION_NAME>")

val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
    this,
    p1,
    ...,
    ...,
    pN
)
```

## App Demo (Single Shared Element)
<img src="https://i.gyazo.com/2fd8d01adfbc1f098657b25b76e98be6.gif" width="350px" height="650px"/>

## App Demo (Multiple Shared Elements)
<img src="https://i.gyazo.com/858928770bb2850df62d34bb0549f7f1.gif" width="350px" height="650px"/>
