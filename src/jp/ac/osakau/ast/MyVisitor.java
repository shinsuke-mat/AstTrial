package jp.ac.osakau.ast;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.LineComment;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class MyVisitor extends ASTVisitor {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("subject/User.java");
		List<String> source = Files.readAllLines(path, Charset.forName("utf-8"));

		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setSource(source.toString().toCharArray());
		CompilationUnit unit = (CompilationUnit) parser.createAST(new NullProgressMonitor());

		MyVisitor visitor = new MyVisitor(unit, source);
		unit.accept(visitor);
	}

    CompilationUnit compilationUnit;
    private List<String> source;

    public MyVisitor(CompilationUnit compilationUnit, List<String> source) {
        super();
        this.compilationUnit = compilationUnit;
        this.source = source;
    }

	@Override
	public boolean visit(MethodDeclaration node) {
		System.out.println("MethodDeclaration: " + node.getName());
		//return super.visit(node);
		return false;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		System.out.println("FieldDeclaration: " + node);
		//return super.visit(node);
		return true;
	}

}
