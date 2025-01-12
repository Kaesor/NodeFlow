package thito.nodeflow.internal.ui.handler;

import javafx.scene.layout.*;
import org.jsoup.nodes.*;
import thito.nodeflow.internal.ui.*;

public class FlowPaneSkinHandler implements SkinHandler<FlowPane> {
    @Override
    public void parse(SkinParser parser, FlowPane node, Element element) {
        if (element.hasAttr("flowpane.prefwraplength")) {
            node.setPrefWrapLength(Double.parseDouble(element.attr("flowpane.prefwraplength")));
        }
    }
}
