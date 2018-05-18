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

package com.desive.fxutils.web;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.html.HTMLAnchorElement;

import java.awt.*;
import java.net.URI;

/**
 * ${@link ChangeListener} to redirect or cancel hyperlinks in a ${@link WebView}
 * Redirect will open the link in the users default desktop browser.
 * Cancel will do nothing.
 *
 * @author Jack DeSive
*/
public class HyperlinkRedirectListener implements ChangeListener<Worker.State>, EventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(HyperlinkRedirectListener.class);

    private final WebEngine webEngine;
    private boolean cancel;

    public HyperlinkRedirectListener(WebEngine webEngine, boolean cancel) {
        this.webEngine = webEngine;
        this.cancel = cancel;
    }

    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        if (Worker.State.SUCCEEDED.equals(newValue)) {
            NodeList anchors = webEngine.getDocument().getElementsByTagName("a");
            for (int i = 0; i < anchors.getLength(); i++) {
                Node node = anchors.item(i);
                EventTarget eventTarget = (EventTarget) node;
                eventTarget.addEventListener("click", this, false);
            }
        }
    }

    @Override
    public void handleEvent(Event event) {

        if(cancel && event.getCancelable()) {
            event.preventDefault();
            return;
        }

        HTMLAnchorElement anchorElement = (HTMLAnchorElement) event.getCurrentTarget();
        String href = anchorElement.getHref();

        if (Desktop.isDesktopSupported()) {
            openLinkInSystemBrowser(href);
        } else {
            LOGGER.warn("OS does not support web browsing. {}", href);
        }

        event.preventDefault();
    }

    /**
     * Open ${@param href} in the users default desktop browser
     *
     * @param href The link to open
     */
    private void openLinkInSystemBrowser(String href) {
        try {
            URI uri = new URI(href);
            Desktop.getDesktop().browse(uri);
        } catch (Throwable e) {
            LOGGER.error("Error on opening link '{}' in system browser", href);
        }
    }
}
