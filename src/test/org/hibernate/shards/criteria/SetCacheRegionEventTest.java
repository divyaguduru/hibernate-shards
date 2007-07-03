/**
 * Copyright (C) 2007 Google Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.

 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */

package org.hibernate.shards.criteria;

import org.hibernate.shards.defaultmock.CriteriaDefaultMock;

import junit.framework.TestCase;

import org.hibernate.Criteria;

/**
 * @author Max Ross <maxr@google.com>
 */
public class SetCacheRegionEventTest extends TestCase {

  public void testOnOpenSession() {
    SetCacheRegionEvent event = new SetCacheRegionEvent(null);
    final boolean[] called = {false};
    Criteria crit = new CriteriaDefaultMock() {
      @Override
      public Criteria setCacheRegion(String cacheRegion) {
        called[0] = true;
        return null;
      }
    };
    event.onEvent(crit);
    assertTrue(called[0]);
  }

}
