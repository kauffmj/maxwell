/*
 * @(#)SortAlgorithm.java	1.6f 95/01/31 James Gosling
 *
 * Copyright (c) 1994-1995 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL or COMMERCIAL purposes and
 * without fee is hereby granted.
 * Please refer to the file http://java.sun.com/copy_trademarks.html
 * for further important copyright and trademark information and to
 * http://java.sun.com/licensing.html for further important licensing
 * information for the Java (tm) Technology.
 *
 * SUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
 * CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
 * PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
 * NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
 * SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
 * SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
 * PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES").  SUN
 * SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
 * HIGH RISK ACTIVITIES.
 */

/**
 * A generic sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author 		James Gosling
 * @version 	1.6f, 31 Jan 1995
 * @modified    Pat Morin on Feb. 7 1996.
 * @modified	Ryan Henry, 22 Feb 2007
 *
 * This file is part of Razza.
 *
 * Razza is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser Public License as published by the Free
 * Software Foundation, either version 2 of the License, or (at your option)
 * any later version.
 *
 * Razza is distributed in the hope that it will be useful, but WITHOUT
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  Se the GNU Lesser Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser Public License along
 * with Razza.  If not, see <http://www.gnu.org/licenses/>.
 */


public abstract class SortAlgorithm {
   private SortItem parent;					// The sort item.
   protected boolean stopRequested = false;	// When true stop sorting.
   protected int[] h;						// Generalized water marks.
   protected int waterMarks = 2;			// Number of water marks.

   public SortAlgorithm() {
      this.h = new int[waterMarks];
   }

  /**
   * Set the parent.
   */
   public void setParent(SortItem p) {
     this.parent = p;
   }

  /**
   * Pause for a while.
   */
   protected void pause() throws Exception {
      if (stopRequested)
	     throw new Exception("Sort Algorithm");

	  this.parent.pause();
   }

  /**
   * Pause for a while and mark item 1.
   */
   protected @Deprecated void pause(int h1) throws Exception {
	  if (stopRequested)
	     throw new Exception("Sort Algorithm");

	  this.parent.pause(h1);
   }

  /**
   * Pause for a while and mark item 1 & 2.
   */
   protected @Deprecated void pause(int h1, int h2) throws Exception {
	  if (stopRequested)
	     throw new Exception("Sort Algorithm");

	  this.parent.pause(h1, h2);
   }

  /**
   * Pause for a while and mark items. - Andrew Kitchen  95/11/22
   */
   protected @Deprecated void pause(int h[]) throws Exception {
	  if (stopRequested)
	     throw new Exception("Sort Algorithm");

      this.parent.pause(h);
   }

  /**
   * Stop sorting.
   */
   public void stop() {
	  this.stopRequested = true;
   }

  /**
   * Initialize
   */
   public void init() {
	  this.stopRequested = false;
   }

  /**
   * This method will be called to
   * sort an array of integers.
   */
   abstract int[] sort(int a[]) throws Exception;

}

