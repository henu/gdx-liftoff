package com.github.czyzby.lml.vis.parser.impl.attribute.draggable;

import com.github.czyzby.lml.parser.LmlParser;
import com.github.czyzby.lml.parser.tag.LmlAttribute;
import com.github.czyzby.lml.parser.tag.LmlTag;
import com.kotcrab.vis.ui.widget.Draggable;

/** See {@link Draggable#setFadingTime(float)}. Mapped to "fadingTime".
 *
 * @author MJ */
public class DraggedFadingTimeLmlAttribute implements LmlAttribute<Draggable> {
    @Override
    public Class<Draggable> getHandledType() {
        return Draggable.class;
    }

    @Override
    public void process(final LmlParser parser, final LmlTag tag, final Draggable actor,
            final String rawAttributeData) {
        actor.setFadingTime(parser.parseFloat(rawAttributeData, actor));
    }
}
