	
public class CustomforAccManage {
	
	    public int sizeOfElements; //the number of elements in the array
	    public String[][] data; //storage for that array elements
	    public int dynamicNewSizeforCapacity;
	    public int NewSize = dynamicNewSizeforCapacity * 2;; // new size of the array when it's need to be resized (to perform dynamically)
	
	    // sets all to methods so that it will be used later in other classes
	    public CustomforAccManage() {
	    	// Initialize the data with a capacity of 10 elements (hold small size of elements as it keeps increasing when addElements is used)
	        data = new String[10][];
	        // initialize the size to 0
	        sizeOfElements = 0;
	    }
	
	    // method to return the current size of array
	    public int returnSize() { 
	        return sizeOfElements;
	    }
	    // get the element at the specific index (used as a method later)
	    public String[] getElements(int dataIndex) {
	    	//return the element of that index
	        return data[dataIndex];
	    }
	    
	    //method to add an element to the array
	    public void addElements(String[] dataElement) {
	    	//check first if the array is full so that it can be resize
	    	if (sizeOfElements >= data.length) {
	    		
	    		//Create a temporary array with the new size
	    		String[][] tempStorageArray = new String[NewSize][];
	    		//copy the element from the previous array into the new one
	    		for (int manualIndex = 0; manualIndex < data.length; manualIndex++ ) {
	    			tempStorageArray[manualIndex] = data[manualIndex];
	    		}
	    		//assign the new array to the data array
	    		data = tempStorageArray;
	    	}
	    	// add the dataElement at the current index of data array at current index and increments it for the next element
	        data[sizeOfElements] = dataElement;
	        //increment the size element
	        sizeOfElements++;
	    }
	    
	    // add a user to the array 
	    public void addUser(int accId, String[] user) {
	        addElements(user);
	    }
	    
	    // iterate and get a user from the array by that user account ID
	    public String[] getUser(int accId) {
	    	//Iterate through size of array 
	        for (int iteratesToGetUser = 0; iteratesToGetUser < sizeOfElements; iteratesToGetUser++) {
	        	//Checks if iterated index is equal to accountID (since data array is a string type make it converted to int)
	            if (Integer.parseInt(data[iteratesToGetUser][0]) == accId) {
	            	//if equal add to data array
	                return data[iteratesToGetUser];
	            }
	        }
	        // returns null if there's no equal accIDs
	        return null;
	    }
	    
	    // iterate and get a user from the array by that user account ID (String)
	    public String[] getUserbyString(String username) {
	    	//Iterate through size of array 
	        for (int iteratesToGetUserString = 0; iteratesToGetUserString < sizeOfElements; iteratesToGetUserString++) {
	        	//Checks if iterated index is equal to accountID
	            if (data[iteratesToGetUserString][1].equals(username)) {
	            	//if equal add to data array
	                return data[iteratesToGetUserString];
	            }
	        }
	        // returns null if there's no equal accIDs
	        return null;
	    }

	    //Update user in array (Used later in AccountManagement)
	    public void updateUser(int accId, String[] user) {
	    	//Iterates through size of array
	        for (int iterateToUpdateUser = 0; iterateToUpdateUser < sizeOfElements; iterateToUpdateUser++) {
	        	//Checks if iterated index is equal to accountID
	            if (Integer.parseInt(data[iterateToUpdateUser][0]) == accId) {
	            	//if equal update the specific user with a new user
	                data[iterateToUpdateUser] = user;
	                return;
	            }
	        }
	    }
	    
	    //Backup method if AccountManagement needs to use listofUser since it is iterative (this will serve to be the copy array)
	    //Pass the array to another array
	    public String[][] passedToOtherArray() {
	    	//creates a new array with the same size as data array
	        String[][] newArray = new String[sizeOfElements][];
	        //iterates over each row in the data array
	        for (int passedIndex = 0; passedIndex < sizeOfElements; passedIndex++) {
	        	//assigning respectively to the newArray basically creating a copy of the data array 
	            newArray[passedIndex] = data[passedIndex];       
	        }
	        //return the fully copied array
	        return newArray;
	    }
	    
	 // Used for the removal of data in the AccountManagement, it takes an integer parameter 
	    public void removeCapabilityforTable(int accId) {
	    	
	    	//it declares a new 2d array with a type of string to store updated data after removing element
	        String[][] newDatawithoutRemovedElements = new String[sizeOfElements - 1][2]; // the size is already decremented to 1, we use two columns since we just needs to remove the equal element
	        //this int type variable is used to keep track the of the newdata string array
	        int newIndex = 0;
	        //for loop to iterate the existing array 
	        for (int iterateOverArrays = 0; iterateOverArrays < sizeOfElements; iterateOverArrays++) {
	        	//checks if the current row is not equal to the account id
	            if (!data[iterateOverArrays][0].equals(String.valueOf(accId))) {
	            	//if false, it will stored the array to the newDatawithoutRemovedElements but if its true it will not be included in the storing
	            	newDatawithoutRemovedElements[newIndex][0] = data[iterateOverArrays][0];
	            	newDatawithoutRemovedElements[newIndex][1] = data[iterateOverArrays][1];
	                //incremented this to proceed to another iteration 
	                newIndex++;
	            }
	        }
	        //update data array with new data array 
	        data = newDatawithoutRemovedElements;
	        //decrement it to reflect to the array
	        sizeOfElements--;
	    }
	}
