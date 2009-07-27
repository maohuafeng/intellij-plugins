package com.intellij.tapestry.core.model.presentation.components;

import com.intellij.tapestry.core.TapestryProject;
import com.intellij.tapestry.core.exceptions.NotTapestryElementException;
import com.intellij.tapestry.core.java.IJavaClassType;
import com.intellij.tapestry.core.model.presentation.Component;
import com.intellij.tapestry.core.model.presentation.TapestryParameter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * The built-in Container element.
 */
public class ContainerComponent extends Component {
    private static Map<String, TapestryParameter> _parameters = new HashMap<String, TapestryParameter>();

    protected ContainerComponent(IJavaClassType componentClass, TapestryProject project) throws NotTapestryElementException {
        super(componentClass, project);
    }

    /**
     * Returns an instance of the Body component.
     *
     * @param tapestryProject the current Tapestry project.
     * @return an instance of the Body component.
     */
    public static ContainerComponent getInstance(TapestryProject tapestryProject) {
      final IJavaClassType classType =
          tapestryProject.getJavaTypeFinder().findType("org.apache.tapestry5.internal.parser.TemplateToken", true);
      return classType == null ? null : new ContainerComponent(classType, tapestryProject);
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return "container";
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    public Map<String, TapestryParameter> getParameters() {
        return _parameters;
    }

    /**
     * {@inheritDoc}
     */
    protected String getElementNameFromClass(String rootPackage) throws NotTapestryElementException {
        return "container";
    }
}
