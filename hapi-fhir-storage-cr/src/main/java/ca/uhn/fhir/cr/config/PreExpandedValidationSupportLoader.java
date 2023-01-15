package ca.uhn.fhir.cr.config;

/*-
 * #%L
 * HAPI FHIR - Clinical Reasoning
 * %%
 * Copyright (C) 2014 - 2023 Smile CDR, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.IValidationSupport;
import ca.uhn.fhir.cr.common.PreExpandedValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.BaseValidationSupportWrapper;
import org.hl7.fhir.common.hapi.validation.support.ValidationSupportChain;

/**
 * This class loads the validation of terminology services.
 */

public class PreExpandedValidationSupportLoader {
	public PreExpandedValidationSupportLoader(ValidationSupportChain theValidationSupportChain, FhirContext theFhirContext) {
		var preExpandedValidationSupport = new PreExpandedValidationSupport(theFhirContext);
		theValidationSupportChain.addValidationSupport(0, preExpandedValidationSupport);
	}
}
