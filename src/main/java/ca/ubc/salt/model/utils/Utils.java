package ca.ubc.salt.model.utils;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Utils
{
    public static <T> Set intersection(List<Set<T>> sets)
    {
	Set common = new HashSet();
	if (sets.size() != 0)
	{
	    ListIterator<Set<T>> iterator = sets.listIterator();
	    common.addAll(iterator.next());
	    while (iterator.hasNext())
	    {
		common.retainAll(iterator.next());
	    }
	}
	return common;
    }
    
    
    public static boolean isTestClass(File classFile)
    {
	return true;
    }
}
