/*
 * @(#)SortItem.java	1.17f 95/04/10 James Gosling
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

import java.awt.*;
import java.io.InputStream;
import java.util.Hashtable;
import java.net.*;

/**
 * A simple applet class to demonstrate a sort algorithm.
 * You can specify a sorting algorithm using the "alg"
 * attribyte. When you click on the applet, a thread is
 * forked which animates the sorting algorithm.
 *
 * @author 		James Gosling
 * @version 	1.17f, 10 Apr 1995
 * @modified 	Ryan Henry, 22 Feb 2007
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
public class SortItem extends java.applet.Applet implements Runnable {
   private Thread kicker;				// The thread that is sorting (or null).
   int arr[];					// The array that is being sorted.
   int h[];					// A generalization of high and low water marks.
   String algName;						// The name of the algorithm.
   SortAlgorithm algorithm;	// The sorting algorithm (or null).

  /**
   * Fill the array with random numbers from 0..n-1.
   */
   void scramble() {
	  int size = ( getHeight() / 2 );
      int a[] = new int[size];
      int h[] = new int[size];
      double f = getWidth() / (double) a.length;

      for (int i = a.length; --i >= 0;) {
         //a[i] = (int)(a.length * f * Math.random());
         a[i] = (int)(i * f);
	  }
	  for (int i = h.length; --i >= 0;)
	     h[i] = -1;
	  /**/ // randomly swap array elements
	  for (int i = a.length; --i >= 0;) {
	     int j = (int)(i * Math.random());
	     int t = a[i];
	     a[i] = a[j];
	     a[j] = t;
	  }
	  /**/

      this.arr = a;
      this.h = h;
   }

  /**
   * Pause a while.
   * @see SortAlgorithm
   */
   void pause() {
      pause(h);
   }

  /**
   * Pause a while, and update high water mark.
   * @see SortAlgorithm
   */
   @Deprecated void pause(int h0) {
	  h[0] = h0;
      pause(h);
   }

  /**
   * Pause a while, and update low & high water marks.
   * @see SortAlgorithm
   */
   @Deprecated void pause(int h0, int h1) {
      h[0] = h0;
      h[h.length - 1] = h1;
      if (kicker != null)
	    repaint();

      try {
         Thread.sleep(20);
      } catch (InterruptedException e){
         // do nothing
      }
   }

  /**
   * Pause a while, and update all water marks.
   * @see SortAlgorithm
   *
   * @modified Andrew Kitchen 95/11/22
   */
   void pause(int H[]) {
	  for (int i=0; i<H.length; i++)
	     h[i] = H[i];
	  if (kicker != null)
         repaint();
      try {
	     Thread.sleep(40);
	  } catch (InterruptedException e){
         // do nothing
	  }
   }

  /**
   * Initialize the applet.
   */
   public @Override void init() {
      String at = getParameter("alg");
      if (at == null)
	    at = "ShakerSortTwo";

	  this.algName = at + "Algorithm";
	  scramble();

	  resize(100, 100);
   }

  /**
   * Paint the array of numbers as a list
   * of horizontal lines of varying lenghts.
   */
   public @Override void paint(Graphics g) {
	  int a[] = arr;
	  int y = getSize().height - 1;

	  // Erase old lines
	  g.setColor(Color.LIGHT_GRAY);
	  for (int i = a.length; --i >= 0; y -= 2)
	     g.drawLine(arr[i], y, getSize().width, y);

      // Draw new lines
      g.setColor(Color.BLACK);
      y = getSize().height - 1;
      for (int i = a.length; --i >= 0; y -= 2)
         g.drawLine(0, y, arr[i], y);

      if (h[0] > -1) {
	     g.setColor(Color.RED);
	     y = h[0] * 2 + 1;
	     g.drawLine(0, y, getSize().width, y);
	  }
	  g.setColor(Color.BLUE);
	  for (int i = h.length; --i > 0;) {
	     if (h[i] > -1) {
            y = h[i] * 2 + 1;
            g.drawLine(0, y, getSize().width, y);
	        h[i] = -1;
	     }
	  }

   }

  /**
   * Update without erasing the background.
   */
   public @Override void update(Graphics g) {
	  paint(g);
   }

  /**
   * Run the sorting algorithm. This method is
   * called by class Thread once the sorting algorithm
   * is started.
   * @see java.lang.Thread#run
   * @see SortItem#mouseUp
   */
   public @Override void run() {
	  try {
	     if (algorithm == null) {
	        algorithm = (SortAlgorithm)Class.forName(algName).newInstance();
	        algorithm.setParent(this);
	     }
         algorithm.init();
         algorithm.sort(arr);
	  } catch(Exception e) {
	     // do nothing
      }
   }

  /**
   * Stop the applet. Kill any sorting algorithm that
   * is still sorting.
   */
   public @Override synchronized void stop() {
      if (kicker != null) {
         try {
	        kicker.interrupt();
         } catch (IllegalThreadStateException e) {
            // do nothing
         }
	     kicker = null;
	  }
	  if (algorithm != null) {
         try {
		    algorithm.stop();
         } catch (IllegalThreadStateException e) {
            // do nothing
         }
	  }
   }

  /**
   * For a Thread to actually do the sorting. This routine makes
   * sure we do not simultaneously start several sorts if the user
   * repeatedly clicks on the sort item.  It needs to be
   * synchronoized with the stop() method because they both
   * manipulate the common kicker variable.
   */
   private synchronized void startSort() {
      if (kicker == null || !kicker.isAlive()) {
	     scramble();
	     repaint();
	     kicker = new Thread(this);
	     kicker.start();
	  }
   }

  /**
   * The user clicked in the applet. Start the clock!
   */
   public boolean mouseUp(java.awt.Event evt, int x, int y) {
      startSort();

	  return true;
   }

}
