/**
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
**/


public class intNode extends Object {

	intNode(int a) {
		value = a;
		next = null;
		prev = null;
	}

	intNode() {
		next = null;
		prev = null;
		value = 0;		//sets value to zero if no value is explicitly given
	}

	public int value;

	public intNode next;
	public intNode prev;

}
