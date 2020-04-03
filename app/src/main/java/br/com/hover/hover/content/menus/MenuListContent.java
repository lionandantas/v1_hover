package br.com.hover.hover.content.menus;



import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.hover.hover.content.Navigator;
import br.com.hover.hover.content.NavigatorContent;
import br.com.hover.hover.content.toolbar.ToolbarNavigator;



public class MenuListContent implements NavigatorContent {

    private static final String TAG = "MenuListNavigatorContent";

    private Menu mMenu;
    private MenuListView mMenuListView;
    private Navigator mNavigator;

    public MenuListContent(@NonNull Context context, @NonNull final Menu menu) {
        this(context, menu, null);
    }

    public MenuListContent(@NonNull Context context, @NonNull final Menu menu, @Nullable View emptyView) {
        mMenu = menu;
        mMenuListView = new MenuListView(context);
        mMenuListView.setMenu(menu);
        mMenuListView.setMenuItemSelectionListener(new MenuListView.MenuItemSelectionListener() {
            @Override
            public void onMenuItemSelected(@NonNull MenuItem menuItem) {
                menuItem.getMenuAction().execute(getView().getContext(), mNavigator);
            }
        });

        setEmptyView(emptyView);
    }

    public void setEmptyView(@Nullable View emptyView) {
        mMenuListView.setEmptyView(emptyView);
    }

    @NonNull
    @Override
    public View getView() {
        return mMenuListView;
    }

    @Override
    public void onShown(@NonNull Navigator navigator) {
        mNavigator = navigator;
        if (navigator instanceof ToolbarNavigator) {
            ((ToolbarNavigator) navigator).getToolbar().setTitle(mMenu.getTitle());
        }
    }

    @Override
    public void onHidden() {
        mNavigator = null;
    }

}
