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
package org.eclipse.lemminx.extensions.xerces.xmlmodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.impl.xs.XMLSchemaValidator;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.NamespaceContext;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.XMLDocumentHandler;
import org.apache.xerces.xni.XMLLocator;
import org.apache.xerces.xni.XMLResourceIdentifier;
import org.apache.xerces.xni.XMLString;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.parser.XMLComponentManager;
import org.apache.xerces.xni.parser.XMLConfigurationException;
import org.apache.xerces.xni.parser.XMLDocumentSource;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLModelRNGValidator extends XMLSchemaValidator implements XMLModelValidator {

	private String href;
	private LemminxJingErrorHandler errorHandler;

	public XMLModelRNGValidator() {
		errorHandler = new LemminxJingErrorHandler();
	}

	@Override
	public void setLocator(XMLLocator locator) {

	}

	@Override
	public void setHref(String href) {
		this.href = href;
	}

	private class LemminxJingErrorHandler implements ErrorHandler {
		private List<SAXParseException> warnings = new ArrayList<>();
		private List<SAXParseException> errors = new ArrayList<>();

		@Override
		public void warning(SAXParseException exception) throws SAXException {
			warnings.add(exception);
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			errors.add(exception);
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			// TODO Auto-generated method stub

		}

		public List<SAXParseException> getErrors() {
			return errors;
		}
	
		public List<SAXParseException> getWarnings() {
			return warnings;
		}
		
	}
	
}