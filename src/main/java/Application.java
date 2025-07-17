import com.tgraph.renderer.Screen;
import com.tgraph.renderer.exception.ScreenDefinitionException;
import com.tgraph.renderer.impl.terminal.TerminalScreen;
import com.tgraph.scene.shape2d.Point2D;
import com.tgraph.scene.shape2d.box.Box;

/**
 * A dummy graphics application used for testing.
 * 
 * @author Nobody
 */
public class Application {
    public static void main (String[] args) throws ScreenDefinitionException {
        TerminalScreen screen = TerminalScreen.getInstance(20,20);
        
        Box box = new Box(new Point2D(0, 0), new Point2D(10, 10));

        screen.render(box);
        screen.flush();
    }
}