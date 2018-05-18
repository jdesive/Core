/*
 * Copyright (C) 2017  Jack DeSive
 *
 * This file is part of Core.
 *
 * Core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.desive.fxutils;

import com.desive.fxutils.web.HyperlinkRedirectListener;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * A ${@link WebView} to display content statically, or so the user cannot change the
 * content displayed in the view.
 *
 * @author Jack DeSive
*/
public class StaticWebView extends StackPane {

    protected WebView webView;
    private HyperlinkRedirectListener hyperlinkRedirectListener;

    protected boolean redirectHyperlinks = false, showContextMenu = false;

    public StaticWebView(String content) {
        this(content, "text/html");
    }

    public StaticWebView(String content, String contentType) {
        webView = new WebView();
        webView.getEngine().loadContent(content, contentType);
        setup();
    }

    public StaticWebView(URI url) throws MalformedURLException {
        webView = new WebView();
        webView.getEngine().load(url.toURL().toExternalForm());
        setup();
    }

    private void setup() {
        setShowContextMenu(showContextMenu);
        setRedirectHyperlinks(redirectHyperlinks);
        getChildren().add(webView);
    }

    /**
     * Set if the hyperlinks in the document should be redirected the the users
     * browser or canceled.
     *
     * @param redirectHyperlinks Redirect hyperlinks
     */
    public void setRedirectHyperlinks(boolean redirectHyperlinks) {

        if(hyperlinkRedirectListener != null)
            webView.getEngine().getLoadWorker().stateProperty().removeListener(hyperlinkRedirectListener);

        hyperlinkRedirectListener = new HyperlinkRedirectListener(webView.getEngine(), !redirectHyperlinks);
        webView.getEngine().getLoadWorker().stateProperty().addListener(hyperlinkRedirectListener);

        this.redirectHyperlinks = redirectHyperlinks;
    }

    /**
     * Set if the context menu should be displayed.
     *
     * @param showContextMenu Show context menu
     */
    public void setShowContextMenu(boolean showContextMenu) {
        webView.setContextMenuEnabled(showContextMenu);
        this.showContextMenu = showContextMenu;
    }

}
