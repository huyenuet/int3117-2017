package net.bqc.jsdf.helper;

import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstRoot;

import java.io.IOException;

public class JsParsingHelper {

    private CompilerEnvirons compilerEnvirons;

    private final static JsParsingHelper instance = new JsParsingHelper();
    public static JsParsingHelper getInstance() { return instance; }

    private JsParsingHelper() {
        compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.setRecordingComments(true);
        compilerEnvirons.setRecordingLocalJsDocComments(true);
        compilerEnvirons.setStrictMode(true);
    }

    public AstRoot parse(String filePath) throws IOException {
        String content = FileHelper.readFileContent(filePath);
        AstRoot astRoot = new Parser(compilerEnvirons).parse(content, null, 0);
        return astRoot;
    }
}
