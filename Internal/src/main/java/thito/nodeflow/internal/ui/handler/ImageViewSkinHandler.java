package thito.nodeflow.internal.ui.handler;

import javafx.scene.image.*;
import org.jsoup.nodes.*;
import thito.nodeflow.internal.ui.*;

public class ImageViewSkinHandler implements SkinHandler<ImageView> {
    @Override
    public void parse(SkinParser parser, ImageView node, Element element) {
        String text = element.ownText();
        if (text != null && !text.isEmpty()) {
            node.setImage(new Image(text));
        }
    }
}
