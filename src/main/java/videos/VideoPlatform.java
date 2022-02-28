package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {

            br.readLine();
            while (br.ready()) {
                String[] elements = br.readLine().split(";");
                channels.add(new Channel(
                        elements[0],
                        Integer.parseInt(elements[1]),
                        Integer.parseInt(elements[2])
                ));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for read!", e);
        }
    }

    public int calculateSumOfVideos() {
        int sumOfVideos = 0;
        for (Channel channel : channels) {
            sumOfVideos += channel.getNumberOfVideos();
        }
        return sumOfVideos;
    }
}
