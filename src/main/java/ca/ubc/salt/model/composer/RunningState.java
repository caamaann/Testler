package ca.ubc.salt.model.composer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;

import java.util.Map.Entry;

import Comparator.NaturalOrderComparator;
import ca.ubc.salt.model.state.TestStatement;
import ca.ubc.salt.model.utils.FileUtils;
import ca.ubc.salt.model.utils.Settings;
import ca.ubc.salt.model.utils.Utils;

public class RunningState
{
    Map<String, String> nameValuePairForCurrentState;
    Map<String, Set<String>> valueNamePairForCurrentState;
    Map<String, Set<String>> typeNamePairForCurrentState;
    Map<String, String> nameTypePairForCurrentState;

    public RunningState()
    {
	nameValuePairForCurrentState = new HashMap<String, String>();
	valueNamePairForCurrentState = new HashMap<String, Set<String>>();
	typeNamePairForCurrentState = new HashMap<String, Set<String>>();
	nameTypePairForCurrentState = new HashMap<String, String>();
    }

    public String getValue(String name)
    {
	return nameValuePairForCurrentState.get(name);
    }

    public Set<String> getName(String value)
    {
	return valueNamePairForCurrentState.get(value);
    }

    public String getType(String name)
    {
	return nameTypePairForCurrentState.get(name);
    }

    public Set<String> getNameForType(String type)
    {
	return typeNamePairForCurrentState.get(type);
    }

    public void put(String name, String value, String type)
    {
	String prevVal = this.getValue(name);
	if (prevVal != null)
	{
	    // valueNamePairForCurrentState.remove(prevVal);
	    Utils.removeFromTheSetInMap(valueNamePairForCurrentState, prevVal, name);
	}
	nameValuePairForCurrentState.put(name, value);
	Utils.addToTheSetInMap(valueNamePairForCurrentState, value, name);

	nameTypePairForCurrentState.put(name, type);
	Utils.addToTheSetInMap(typeNamePairForCurrentState, type, name);

	// valueNamePairForCurrentState.put(value, name);
    }

    public void update(TestStatement stmt, Map<String, String> renameMap)
    {
	String prevState = stmt.getName();
	Map<String, SimpleName> vars = stmt.getAllVars();
	if (vars == null)
	    return;
	Set<String> varsName = Utils.getNameSet(vars.values());
	String nextState = Utils.nextOrPrevState(
		Arrays.asList(new String[] { Utils.getTestCaseNameFromTestStatement(prevState) }), prevState, true);
	Map<String, String> nameValuePair = null;
	try
	{
	    nameValuePair = TestCaseComposer.nameValuePairs.get(nextState);
	} catch (ExecutionException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	for (Entry<String, String> entry : nameValuePair.entrySet())
	{
	    String name = entry.getKey();
	    if (varsName.contains(name))
	    {
		String value = entry.getValue();

		String renamedName = renameMap.get(name);

		SimpleName sname = vars.get(name);
//		String type = getTypeOfValue(value);
		String type = "";
		if (sname != null)
		{
//		    ITypeBinding typeBind = sname.resolveTypeBinding();
		    IBinding bind = sname.resolveBinding();
		    IVariableBinding iv = (IVariableBinding) bind;
		    ITypeBinding typeBind = iv.getType();
		    if (typeBind != null)
			type = typeBind.getName();
		    else
		    {
			Settings.consoleLogger.error("typeBinding is null for " + sname.toString() + " in " + stmt.toString());
		    }
		}
		if (renamedName != null)
		    name = renamedName;

		this.put(name, value, type);
	    }
	}

    }

    @Override
    public RunningState clone() throws CloneNotSupportedException
    {
	// TODO Auto-generated method stub
	RunningState rs = new RunningState();
	rs.nameValuePairForCurrentState.putAll(this.nameValuePairForCurrentState);
	for (Entry<String, Set<String>> entry : this.valueNamePairForCurrentState.entrySet())
	{
	    Set<String> newSet = new HashSet<String>();
	    newSet.addAll(entry.getValue());
	    rs.valueNamePairForCurrentState.put(entry.getKey(), newSet);

	}
	rs.nameTypePairForCurrentState.putAll(this.nameTypePairForCurrentState);
	for (Entry<String, Set<String>> entry : this.typeNamePairForCurrentState.entrySet())
	{
	    Set<String> newSet = new HashSet<String>();
	    newSet.addAll(entry.getValue());
	    rs.typeNamePairForCurrentState.put(entry.getKey(), newSet);
	    
	}
	return rs;
    }

    public RunningState(Collection<String> testCases)
    {
	nameValuePairForCurrentState = new HashMap<String, String>();
	valueNamePairForCurrentState = new HashMap<String, Set<String>>();
	typeNamePairForCurrentState = new HashMap<String, Set<String>>();
	nameTypePairForCurrentState = new HashMap<String, String>();

	for (String testCase : testCases)
	{
	    Map<String, String> nameValuePair = FileUtils.getNameValuePairs(testCase + "-0.xml");
	    for (Entry<String, String> entry : nameValuePair.entrySet())
		this.put(entry.getKey(), entry.getValue(), getTypeOfValue(entry.getValue()));
	}

    }

    public static String getTypeOfValue(String origVal)
    {
	int end = origVal.indexOf('>');
	String val = origVal.substring(0, end);
	int begin = val.lastIndexOf('.');
	if (begin == -1)
	    begin = 0;
	val = val.substring(begin + 1);
	if (val.equals("NullValueType"))
	{
	    begin = origVal.indexOf("<type>");
	    begin += 7;
	    end = origVal.indexOf("</type>");
	    return origVal.substring(begin, end);
	}
	else
	    return val;
    }

    public RunningState(Collection<String> testCases, String mainTestClass)
    {
	nameValuePairForCurrentState = new HashMap<String, String>();
	valueNamePairForCurrentState = new HashMap<String, Set<String>>();
	typeNamePairForCurrentState = new HashMap<String, Set<String>>();
	nameTypePairForCurrentState = new HashMap<String, String>();

	Set<String> done = new HashSet<String>();
	for (String testCase : testCases)
	{
	    String testClass = Utils.getTestClassNameFromTestCase(testCase);
	    if (done.contains(testClass))
		continue;
	    Map<String, String> nameValuePair = FileUtils.getNameValuePairs(testCase + "-0.xml");
	    for (Entry<String, String> entry : nameValuePair.entrySet())
	    {
		String name = entry.getKey();
		if (!testClass.equals(mainTestClass))
		    name = name + "_" + testClass;
		this.put(name, entry.getValue(), getTypeOfValue(entry.getValue()));
	    }
	    done.add(testClass);
	}
    }

}