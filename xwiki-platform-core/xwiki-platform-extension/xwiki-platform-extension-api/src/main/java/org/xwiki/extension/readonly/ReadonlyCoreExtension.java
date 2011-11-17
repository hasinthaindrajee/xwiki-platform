/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.extension.readonly;

import org.xwiki.extension.CoreExtension;
import org.xwiki.extension.repository.ExtensionRepository;
import org.xwiki.extension.wrap.WrappingCoreExtension;

/**
 * Provide a readonly access to a core extension.
 * 
 * @param <T> the extension type
 * @version $Id$
 */
public class ReadonlyCoreExtension<T extends CoreExtension> extends WrappingCoreExtension<T> implements CoreExtension
{
    /**
     * @param extension the wrapped core extension
     */
    public ReadonlyCoreExtension(T extension)
    {
        super(extension);
    }

    // Extension

    @Override
    public ExtensionRepository getRepository()
    {
        return ReadonlyUtils.unmodifiableExtensionRepository(super.getRepository());
    }
}