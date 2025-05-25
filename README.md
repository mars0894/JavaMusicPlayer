# Java Music Player

![Music Player Screenshot](PROJECT/src/assets/screenshot.png) 

A lightweight Java music player with playlist management, built using Swing and audio processing libraries.

## Features

-  Play, pause, next, and previous song controls
- 🖼 Album art and metadata display (title, artist)
-  Interactive playback progress slider
-  Playlist creation and management
  - Add/remove songs
  - Save/load playlists as `.txt` files
-  Seek functionality within tracks
-  Volume control (future implementation)

## Technologies

- **Core**: Java 11+
- **UI**: Java Swing
- **Audio Playback**: JLayer (javazoom)
- **Metadata Processing**: 
  - mp3agic (MP3 parsing)
  - jaudiotagger (ID3 tags)








## Installation

1. **Prerequisites**:
   - Java JDK 11+
   - Maven (for dependency management)






mvn compile exec:java -Dexec.mainClass="View.MainFrame"

3. 
