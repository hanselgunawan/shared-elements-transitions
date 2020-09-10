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

## App Demo
<img src="https://i.gyazo.com/2fd8d01adfbc1f098657b25b76e98be6.gif" width="350px" height="650px"/>
