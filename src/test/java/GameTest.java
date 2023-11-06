import org.example.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @InjectMocks
    private Game game;

    @Mock
    Scanner scanner;

    @Test
    public void gameTest() {
        when(scanner.nextLine()).thenReturn("Quit");
        game.play();
    }
}
