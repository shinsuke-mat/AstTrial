package jp.ac.osakau.ast;

import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class MyVisitor extends ASTVisitor {

	public static void main(String[] args) throws IOException {
		// 解析対象のソースコード（複数可）
		String[] sources = { "subject/User.java" };

		// 解析器の生成
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		MyASTRequestor requestor = new MyASTRequestor();
		parser.createASTs(sources, null, new String[] {}, requestor, new NullProgressMonitor());

		// 対象ソースごとにASTの解析を行う
		for (CompilationUnit unit : requestor.units) {
			MyVisitor visitor = new MyVisitor();
			unit.accept(visitor);
		}
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		System.out.println("TypeDeclaration: " + node.getName());
		return super.visit(node);
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		System.out.println("MethodDeclaration: " + node.getName());
		return super.visit(node);
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		System.out.println("FieldDeclaration: " + node);
		return super.visit(node);
	}

	@Override
	public boolean visit(IfStatement node) {
		System.out.println("if: " + node);
		return super.visit(node);
	}

	@Override
	public boolean visit(VariableDeclarationFragment node) {
		System.out.println("var: " + node);
		return true;
	}

}
