/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package com.netflix.spinnaker.halyard.config.model.v1.pubsub.google;

import com.netflix.spinnaker.halyard.config.model.v1.node.LocalFile;
import com.netflix.spinnaker.halyard.config.model.v1.node.Subscription;
import com.netflix.spinnaker.halyard.config.model.v1.node.Validator;
import com.netflix.spinnaker.halyard.config.problem.v1.ConfigProblemSetBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GoogleSubscription extends Subscription {
  private String project;
  private String subscriptionName;
  @LocalFile private String jsonPath;
  @LocalFile private String templatePath;
  private Integer ackDeadlineSeconds;
  private MessageFormat messageFormat;

  @Override
  public void accept(ConfigProblemSetBuilder psBuilder, Validator v) {
    v.validate(psBuilder, this);
  }

  public static enum MessageFormat {
    GCS,
    GCR,
    CUSTOM
  }
}
