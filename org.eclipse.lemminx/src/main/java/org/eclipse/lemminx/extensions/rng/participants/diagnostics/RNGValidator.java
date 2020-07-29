package org.eclipse.lemminx.extensions.rng.participants.diagnostics;

import java.util.List;

import org.apache.xerces.xni.parser.XMLEntityResolver;
import org.eclipse.lemminx.dom.DOMDocument;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.jsonrpc.CancelChecker;

public class RNGValidator {

	public static void doDiagnostics(DOMDocument xmlDocument, XMLEntityResolver entityResolver,
			List<Diagnostic> diagnostics, CancelChecker monitor) {
	}
	
}