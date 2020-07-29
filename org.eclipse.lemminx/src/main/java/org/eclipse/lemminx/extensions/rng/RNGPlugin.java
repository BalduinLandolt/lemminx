/*******************************************************************************
* Copyright (c) 2020 Balduin Landolt and others.
* All rights reserved. This program and the accompanying materials
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v20.html
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*     Balduin Landolt - initial API and implementation
*******************************************************************************/
package org.eclipse.lemminx.extensions.rng;

import org.eclipse.lemminx.extensions.rng.participants.diagnostics.RNGDiagnosticsParticipant;
import org.eclipse.lemminx.services.extensions.IXMLExtension;
import org.eclipse.lemminx.services.extensions.XMLExtensionsRegistry;
import org.eclipse.lemminx.services.extensions.diagnostics.IDiagnosticsParticipant;
import org.eclipse.lsp4j.InitializeParams;

public class RNGPlugin implements IXMLExtension {

	private final IDiagnosticsParticipant diagnosticsParticipant;

	public RNGPlugin() {
		diagnosticsParticipant = new RNGDiagnosticsParticipant();
	}

	@Override
	public void start(InitializeParams params, XMLExtensionsRegistry registry) {
		// TODO more?
		registry.registerDiagnosticsParticipant(diagnosticsParticipant);
	}

	@Override
	public void stop(XMLExtensionsRegistry registry) {
		// TODO more?
		registry.unregisterDiagnosticsParticipant(diagnosticsParticipant);
	}
	
}