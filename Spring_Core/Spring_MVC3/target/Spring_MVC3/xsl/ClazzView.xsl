<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <body>
                <div align="center">
                    <xsl:apply-templates />
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="clazz">
        <table border="1" width="250">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
            </tr>
        </table>
    </xsl:template>
</xsl:stylesheet>