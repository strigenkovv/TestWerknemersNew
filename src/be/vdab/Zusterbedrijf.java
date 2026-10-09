package be.vdab;

import be.vdab.personeel.Werknemer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Zusterbedrijf {

    public static void main(String[] args) {
        try (var stream = new ObjectInputStream(
                Files.newInputStream(Path.of("personeel.dat")))) {

            var werknemers = (List<Werknemer>) stream.readObject();
            werknemers.forEach(IO::println);

        } catch (IOException | ClassNotFoundException ex) {
            IO.println("Fout bij het lezen van personeel.dat: " + ex.getMessage());
        }
    }
}
