package org.eclipse.lemminx.extensions.rng.participants.diagnostics;

import java.util.List;

import org.apache.xerces.xni.parser.XMLEntityResolver;
import org.eclipse.lemminx.dom.DOMDocument;
import org.eclipse.lemminx.services.extensions.diagnostics.IDiagnosticsParticipant;
import org.eclipse.lemminx.utils.DOMUtils;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.jsonrpc.CancelChecker;

public class RNGDiagnosticsParticipant implements IDiagnosticsParticipant {

	@Override
	public void doDiagnostics(DOMDocument xmlDocument, List<Diagnostic> diagnostics, CancelChecker monitor) {
		if (!DOMUtils.isRNG(xmlDocument)) {
			// Don't use the XSD validator, if the XML document is not a XML Schema.
			return;
		}
		// Get entity resolver (XML catalog resolver, XML schema from the file
		// associations settings., ...)
		XMLEntityResolver entityResolver = xmlDocument.getResolverExtensionManager();
		// Process validation
		RNGValidator.doDiagnostics(xmlDocument, entityResolver, diagnostics, monitor);
	}
	
}