// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.angular2.inspections.quickfixes;

import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.util.ObjectUtils;
import org.angular2.lang.Angular2Bundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

public class ConvertToPropertyBindingQuickFix implements LocalQuickFix {

  private final String myPropertyName;

  public ConvertToPropertyBindingQuickFix(@NotNull String propertyName) {
    myPropertyName = propertyName;
  }

  @Nls
  @NotNull
  @Override
  public String getName() {
    return Angular2Bundle.message("angular.quickfix.template.bind-to-property.name", myPropertyName);
  }

  @Nls
  @NotNull
  @Override
  public String getFamilyName() {
    return Angular2Bundle.message("angular.quickfix.template.bind-to-property.family");
  }

  @Override
  public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
    final XmlAttribute attribute = ObjectUtils.tryCast(descriptor.getPsiElement().getParent(), XmlAttribute.class);
    if (attribute != null) {
      attribute.setName("[" + myPropertyName + "]");
    }
  }
}
