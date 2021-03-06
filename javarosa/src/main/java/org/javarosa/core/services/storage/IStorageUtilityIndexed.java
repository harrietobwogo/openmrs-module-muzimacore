package org.javarosa.core.services.storage;

import org.javarosa.core.util.InvalidIndexException;
import org.javarosa.core.util.externalizable.Externalizable;

import java.util.NoSuchElementException;
import java.util.Vector;

/* TEMPORARY / EXPERIMENTAL */

public interface IStorageUtilityIndexed extends IStorageUtility {

	/**
	* Retrieves a Vector of IDs of Externalizable objects in storage for which the field
	* specified contains the value specified.
	* 
	* @param fieldName The name of a field which should be evaluated
	* @param value The value which should be contained by the field specified
	* @return A Vector of Integers such that retrieving the Externalizable object with any
	* of those integer IDs will result in an object for which the field specified is equal
	* to the value provided. 
	* @throws RuntimeException (Fix this exception type) if the field is unrecognized by the
	* meta data
	*/
	 	Vector getIDsForValue(String fieldName, Object value);
 	/**
 	* 
 	* Retrieves a Externalizable object from the storage which is reference by the unique index fieldName.
 	* 
 	* @param fieldName The name of the index field which will be evaluated
 	* @param value The value which should be set in the index specified by fieldName for the returned 
 	* object.
 	* @return An Externalizable object e, such that e.getMetaData(fieldName).equals(value);
 	* @throws java.util.NoSuchElementException If no objects reside in storage for which the return condition
 	* can be successful.
 	* @throws InvalidIndexException If the field used is an invalid index, because more than one field in the Storage 
 	* contains the value of the index requested.
 	*/
 	Externalizable getRecordForValue(String fieldName, Object value) throws NoSuchElementException, InvalidIndexException;
	
}
