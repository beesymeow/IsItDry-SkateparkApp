# App Description and Design

#### Name
Cameron Munro

#### Matriculation Number
2424161

## App Name: IsItDry (Skatepark App)

Android Studio made app using kotlin and implementing weather API to display if a skatepark is dry or when it 
will be dry next by calculating drying speed and time since last rainfall. Also with features to record tricks 
you have done to a log and post tricks for other users to see and interact with.

## Basic UI
The app loads onto a screen with the (nearest to them or last visited) skatepark displayed. This includes widgets
displaying current status of park, dry or wet, and how long till dry if needed. There is a button for the user to press if
the skatepark is wet ("Wet?") which then asks some information (When did rain stop?) then updates that park's page.

## Basic Interactivity
When users interact with the "Wet?" button they are displayed a form which asks some details about the rain and dryness of the
park. If the park is displayed as dry but a user enters it's wet the page updates to display that it's currently wet.

## Screen Management

## Lists in UI

## Architecture Components

## Multi-Screen Navigation
The app has multiple screens as each park has it's own. Navigation between them is done by either search bar or the list containing 
available to view parks. (Write about user posts and clips and such here)

## Internet Data
The app's core functionality is using (weather data) to know if the skatepark is dry. If the API says it's raining in an area
the display of the park will display raining on the UI via image and text.

## Error Handling
