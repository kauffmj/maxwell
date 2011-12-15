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



public class LinkedQueue extends Object {
	private intNode start;
	private intNode end;

	private int length;	//number of elements

	//Constructor
	LinkedQueue() {
		start = null;
		end = null;
		length = 0;
	}

	//Add an item to the end of the queue
	public void enqueue(int num) {
		length++;	//increment the number of objects

		//Create new node with given info
		intNode temp = new intNode(num);

		//If this is the first time, then do this
		if (start == null) {
			start = temp;	//make start = to this
			end = start;	//start and end point to the same node
		}
		else {
			//make the new node's next pointer
			//point to the end
			end.next = temp;
			//make start point to the new object
			end = temp;
		}
		temp = null;
	}

	//Dequeue -- returns the integer in the intNode
	//From the front of the queue
	//Assumes that the queue is not empty
	public int dequeue() {
		length--;

		int temp = start.value;
		intNode tempNode;

		tempNode = start;

		start = start.next;	//let start point to the next node

		tempNode = null;	//clear the first object

		return temp;
	}

	//returns true if its empty
	public boolean isEmpty() {
		return (length == 0);
	}

}
