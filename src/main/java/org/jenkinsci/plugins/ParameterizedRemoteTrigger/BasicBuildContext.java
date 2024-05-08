package org.jenkinsci.plugins.ParameterizedRemoteTrigger;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.Nullable;

import hudson.FilePath;
import hudson.model.Run;
import hudson.model.TaskListener;

/**
 * This object wraps a {@link Run}, {@link FilePath}, and {@link TaskListener} -
 * the typical objects passed from one method to the other in a Jenkins Builder/BuildStep implementation.<br>
 * <br>
 * The reason for wrapping is simplicity.
 */
public class BasicBuildContext
{
    @Nullable @CheckForNull
    public final Run<?, ?> run;

    @Nullable @CheckForNull
    public final FilePath workspace;

    @Nullable @CheckForNull
    public final TaskListener listener;


    public BasicBuildContext(@Nullable Run<?, ?> run, @Nullable FilePath workspace, @Nullable TaskListener listener) {
        this.run = run;
        this.workspace = workspace;
        this.listener = listener;
    }
}
