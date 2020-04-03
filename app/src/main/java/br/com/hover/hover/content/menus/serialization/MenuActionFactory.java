package br.com.hover.hover.content.menus.serialization;




import androidx.annotation.NonNull;

import br.com.hover.hover.content.menus.Menu;
import br.com.hover.hover.content.menus.MenuAction;


/**
 * Creates {@link MenuAction}s given various action IDs.
 */
public interface MenuActionFactory {

    MenuAction createShowSubmenuMenuAction(@NonNull Menu menu);

    MenuAction createMenuActionForId(@NonNull String actionId);

}
