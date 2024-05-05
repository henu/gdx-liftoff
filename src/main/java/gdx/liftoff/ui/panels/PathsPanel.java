package gdx.liftoff.ui.panels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.widget.file.FileChooserAdapter;
import gdx.liftoff.Main;
import gdx.liftoff.ui.data.UserData;

import static gdx.liftoff.Main.*;

/**
 * Table that displays the project path and the android sdk path if android is selected as a platform
 */
public class PathsPanel extends Table implements Panel {
//todo:highlight field
    public PathsPanel() {
        //project label
        defaults().space(SPACE_MEDIUM);
        Label label = new Label(prop.getProperty("destinationPrompt"), skin, "field");
        label.setEllipsis("...");
        add(label).minWidth(0);

        //project field
        addField(UserData.projectPath);

        if (UserData.platforms.contains(prop.getProperty("android"), false)) {
            //android label
            row();
            label = new Label(prop.getProperty("androidSdkPrompt"), skin, "field");
            label.setEllipsis("...");
            add(label).minWidth(0);

            //android field
            addField(UserData.androidPath);
        }
    }

    /**
     * Convenience method to add fields to the table.
     * @param text
     */
    private void addField(String text) {
        TextButton browseFieldButton = new TextButton(text, skin, "field");
        browseFieldButton.getLabel().setAlignment(Align.left);
        browseFieldButton.getLabel().setEllipsis("...");
        browseFieldButton.getLabelCell().minWidth(0);
        add(browseFieldButton).growX().minWidth(100);
        addHandListener(browseFieldButton);
        onChange(browseFieldButton, () -> Main.pickDirectory(Gdx.files.absolute("C://"), new FileChooserAdapter() {
            @Override
            public void canceled() {
                super.canceled();
            }

            @Override
            public void selected(Array<FileHandle> files) {
                super.selected(files);
            }
        }));
    }

    @Override
    public void captureKeyboardFocus() {

    }
}
