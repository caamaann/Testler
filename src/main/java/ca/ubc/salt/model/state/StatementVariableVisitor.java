package ca.ubc.salt.model.state;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;

public class StatementVariableVisitor extends ASTVisitor
{
    Set<SimpleName> vars = new HashSet<SimpleName>();

    public boolean visit(SimpleName node)
    {
	final IBinding nodeBinding = node.resolveBinding();
	if (nodeBinding instanceof IVariableBinding)
	{
	    IVariableBinding ivb = (IVariableBinding) nodeBinding;
	    vars.add(node);
	    // System.out.println(ivb.getName());
	    // System.out.println(ivb.getType().getQualifiedName());
	}
	// else
	// {
	// System.out.println(node + " " + nodeBinding);
	// }
	return true;
    }

    public Set<SimpleName> getVars()
    {
	return vars;
    }

    public void setVars(Set<SimpleName> readVars)
    {
	this.vars = readVars;
    }

}