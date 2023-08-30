
public class AccountManagement {
	
	//declares a static listofUsers of type Custom2dArray
    public static CustomforAccManage ListofUsers;
    
   //Constructor to take arrays for accountID, Username, Password, Roles
    public AccountManagement(int[] accId, String[] username, String[] password, String[] roles) {
    	//Creata a new instance of Custom2dArray to store users
    	  ListofUsers = new CustomforAccManage(); 
    	  
    	  //Iterates over all arrays
          for (int iterateOverArrays = 0; iterateOverArrays < accId.length; iterateOverArrays++) {
        	  //Convert AccountID to String
              String[] StringUsers = { Integer.toString(accId[iterateOverArrays]), username[iterateOverArrays], password[iterateOverArrays], roles[iterateOverArrays] };
              //Adds the User by using the addUser method in Custom2dArray
              ListofUsers.addUser(iterateOverArrays, StringUsers);
          }
      }
    
    	//Validates a user by checking account ID If match by the password *Used in resetPassword*
      public boolean validateUser(int userSpecificID, String password) {
    	  // get the individual user data for the given userID from the ListofUsers object 
          String[] thatUser = ListofUsers.getUser(userSpecificID);
          //Check first if that user really exist in the listofUsers and also if the password matches the stored password since String[] password is in index[2]
          if (thatUser != null && thatUser[2].equals(password)) {
              return true; //User is valid
          } else {
              return false;// User is not valid 
          }
      }
      
      public boolean validateUserinLoginPage(String username, String password) {
    	    // get the individual user data for the given username from the ListofUsers object
    	    String[] thatUser = ListofUsers.getUserbyString(username);
    	    // Check if the user exists in the listofUsers and if the password matches the stored password (index 2)
    	    if (thatUser != null && thatUser[2].equals(password)) {
    	        return true; // User is valid
    	    } else {
    	        return false; // User is not valid
    	    }
    	}

      
      //Updates the password of a user with the specified AccountID *sets after the validateUser
      public void updatePassUser(int accId, String newPass) {
    	  // get the individual user data for the given userID from the ListofUsers object 
          String[] thatUser = ListofUsers.getUser(accId);
          //Checks if the user exist 
          if (thatUser != null) {
        	  //Update the password now with the new 
              thatUser[2] = newPass;
              //Also updates it in the ListofUsers *updateUser method comes from the Custom2dArray
              ListofUsers.updateUser(accId, thatUser);
          }
      }
      
      //Updates the username of a user with the specified AccountID 
      public void updateUsername(int accId, String newUser) {
    	  // get the individual user data for the given userID from the ListofUsers object 
    	  String[] thatUser = ListofUsers.getUser(accId);
          //Checks if the user exist 
    	  if(thatUser != null) {
        	  //Update the username now with the new 
    		  thatUser[1] = newUser;
              //Also updates it in the ListofUsers *updateUser method comes from the Custom2dArray
    		  ListofUsers.updateUser(accId, thatUser);
    	  }
    	  
      }
      //Updates the username of a user with the specified AccountID 
      public void updateUserRole(int accId, String newRole) {
    	  // get the individual user data for the given userID from the ListofUsers object 
    	  String[] thatUser = ListofUsers.getUser(accId);
          //Checks if the user exist 
    	  if(thatUser != null) {
        	  //Update the role now with the new 
    		  thatUser[3] = newRole;
              //Also updates it in the ListofUsers *updateUser method comes from the Custom2dArray
    		  ListofUsers.updateUser(accId, thatUser);
    	  }
    	  
      }
      
      // retrieves list of users stored in the Custom2DArray
      public CustomforAccManage getListOfUsers() {
    	  //return the Custom2dArray object containing the list of users
          return ListofUsers;
      }
      
      //Gets the Password from specific accID
      public String getPasscode(int accountID) {
    	  // get the individual user data for the given userID from the ListofUsers object 
          String[] thatUser = ListofUsers.getUser(accountID);
          //Checks if user exist 
          if (thatUser != null) {
        	  // return the password from that accountID
              return thatUser[2];
          } else {
        	  //counter measure if user doesn't exist
              return null;
          }
      }
      //Gets the Password from specific accID *Accepts Integer
      public String getUserInfo(int accId) {
    	  // get the individual user data for the given userID from the ListofUsers object 
          String[] userInfo = ListofUsers.getUser(accId);
          //Checks if user exist 
          if (userInfo != null) {
        	  // return the username from that accountID
              return userInfo[1];
          } else {
        	  //counter measure if user doesn't exist
              return null;
          }
      }
      
      //Gets the Password from specific accID *Accepts String (Used later in Validating the Login)
      public String getUserInfobyString(String username) {
    	  // get the individual user data for the given userID from the ListofUsers object 
          String[] userInfo = ListofUsers.getUserbyString(username);
          //Checks if user exist 
          if (userInfo != null) {
        	  // return the password from that accountID
              return userInfo[2];
          } else {
        	  //counter measure if user doesn't exist
              return null;
          }    
      } 

      //Removes the User that accepts index (Used later in AccountManagement tab)
      public void removeUserInfo(int index) {
    	  // removeCapabilityforTable is method from Custom2dArray used to remove the current selected index
    	    ListofUsers.removeCapabilityforTable(index);
    	}

	public String getUserRoleByUsername(String getUsernametoLocate) {
		String[] userInfo = ListofUsers.getUserbyString(getUsernametoLocate);
	    //Checks if user exist 
	    if (userInfo != null) {
	        // return the role from that username (assuming the role is at index 3)
	        return userInfo[3];
	    } else {
	        //counter measure if user doesn't exist
	        return null;
	    }

	}


  }






