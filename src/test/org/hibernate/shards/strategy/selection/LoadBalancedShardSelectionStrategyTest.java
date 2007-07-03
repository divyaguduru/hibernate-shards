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

package org.hibernate.shards.strategy.selection;

import org.hibernate.shards.ShardId;
import org.hibernate.shards.loadbalance.ShardLoadBalancer;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;

/**
 * @author Max Ross <maxr@google.com>
 */
public class LoadBalancedShardSelectionStrategyTest extends TestCase {

  public void testSelectShardForNewObject() {
    final List<ShardId> shardIds = Collections.emptyList();
    final ShardId shardId = new ShardId(1);
    ShardLoadBalancer balancer = new ShardLoadBalancer() {
      public ShardId getNextShardId() {
        return shardId;
      }
    };
    LoadBalancedShardSelectionStrategy strategy = new LoadBalancedShardSelectionStrategy(balancer);
    assertSame(shardId, strategy.selectShardIdForNewObject(null));
    assertSame(shardId, strategy.selectShardIdForNewObject(null));
  }
}
