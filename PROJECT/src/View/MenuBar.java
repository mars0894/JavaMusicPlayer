package View;

import Controller.MusicPlaylistDialog;
import Model.MusicPlayer;
import Model.Song;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class MenuBar extends JMenuBar {
    private MusicPlayer musicPlayer;
    private JFileChooser jFileChooser;
    private MainFrame mainFrame;

    public MenuBar(MainFrame mainFrame, MusicPlayer musicPlayer, JFileChooser jFileChooser) {
        this.mainFrame = mainFrame;
        this.musicPlayer = musicPlayer;
        this.jFileChooser = jFileChooser;

        // Create and add menus
        createMenus();
    }


    private void createMenus() {
        // Song menu
        JMenu songMenu = new JMenu("Song");
        add(songMenu);

        // Load Song item
        JMenuItem loadSong = new JMenuItem("Load Song");
        loadSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3", "mp3"));
                jFileChooser.setCurrentDirectory(new File("PROJECT/src/assets"));
                int result = jFileChooser.showOpenDialog(mainFrame);
                File selectedFile = jFileChooser.getSelectedFile();

                if (result == JFileChooser.APPROVE_OPTION && selectedFile != null) {
                    Song song = new Song(selectedFile.getPath());
                    musicPlayer.loadSong(song);
                    mainFrame.updateSongTitleAndArtist(song);
                    mainFrame.updatePlaybackSlider(song);
                    mainFrame.enablePauseButtonDisablePlayButton();
                }
            }
        });
        songMenu.add(loadSong);

        // Playlist menu
        JMenu playlistMenu = new JMenu("Playlist");
        add(playlistMenu);

        // Create Playlist item
        JMenuItem createPlaylist = new JMenuItem("Create Playlist");
        createPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MusicPlaylistDialog(mainFrame).setVisible(true);
            }
        });
        playlistMenu.add(createPlaylist);

        // Load Playlist item
        JMenuItem loadPlaylist = new JMenuItem("Load Playlist");
        loadPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileFilter(new FileNameExtensionFilter("Playlist Files", "txt"));
                jFileChooser.setCurrentDirectory(new File("PROJECT/src/assets"));

                int result = jFileChooser.showOpenDialog(mainFrame);
                File selectedFile = jFileChooser.getSelectedFile();

                if (result == JFileChooser.APPROVE_OPTION && selectedFile != null) {
                    musicPlayer.stopSong();
                    musicPlayer.loadPlaylist(selectedFile);
                    mainFrame.updateSongTitleAndArtist(musicPlayer.getCurrentSong());
                    mainFrame.updatePlaybackSlider(musicPlayer.getCurrentSong());
                    mainFrame.enablePauseButtonDisablePlayButton();
                }
            }
        });
        playlistMenu.add(loadPlaylist);
    }
}