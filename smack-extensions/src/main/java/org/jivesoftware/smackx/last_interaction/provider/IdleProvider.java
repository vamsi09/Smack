/**
 *
 * Copyright © 2018 Paul Schaub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smackx.last_interaction.provider;

import java.util.Date;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.last_interaction.element.IdleElement;

import org.jxmpp.util.XmppDateTime;
import org.xmlpull.v1.XmlPullParser;

public class IdleProvider extends ExtensionElementProvider<IdleElement> {

    public static final IdleProvider TEST_INSTANCE = new IdleProvider();

    /**
     * {@inheritDoc}
     */
    @Override
    public IdleElement parse(XmlPullParser parser, int initialDepth) throws Exception {
        String dateString = parser.getAttributeValue(null, IdleElement.ATTR_SINCE);
        Date since = XmppDateTime.parseXEP0082Date(dateString);
        return new IdleElement(since);
    }
}
