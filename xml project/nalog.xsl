<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version = "2.0" 
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
     <xsl:template match="/">
        <html>
            <head>
                <title>Nalog</title>
                <style type="text/css">
                    table {
                        font-family: serif;
                        border-collapse: collapse;
                        margin: 15px auto 15px auto;
                        width: 90%;
                    }
                    th, td {
                        text-align: left;
                        padding: 5px;
                    }
                    tr:nth-child(even){ background-color: #f2f2f2 }
                    th {
                        background-color: #4caf50;
                        font-family: sans-serif;
                        color: white;
                    }
                    tr { border: 1px solid darkgrey; }
                    tr:hover {
                        font-style: italic;
                        background-color: #cae8cb;
                    }
                    body { font-family: sans-serif; }
                   p { text-indent: 5px; }
                    .sup {
                        vertical-align: super;
                        padding-left: 4px;
                        font-size: small;
                        text-transform: lowercase;
                    }
                    
                </style>
            </head>
            <body>
                <h1>Nalog</h1>
                <p>idPoruke: <xsl:value-of select="nalog/idPoruke"/></p>
                <p>duznik: <xsl:value-of select="nalog/duznik"/></p>
                <p>svrhaPlacanja: <xsl:value-of select="nalog/svrhaPlacanja"/></p>
                <p>primalac: <xsl:value-of select="nalog/primalac"/></p>
                <p>datumNaloga: <xsl:value-of select="nalog/datumNaloga"/></p>
                <p>datumValute: <xsl:value-of select="nalog/datumValute"/></p>
                <p>racunDuznika: <xsl:value-of select="nalog/racunDuznika"/></p>
                <p>modelZaduzenja: <xsl:value-of select="nalog/modelZaduzenja"/></p>
                <p>pozivNaBrojZaduzenja: <xsl:value-of select="nalog/pozivNaBrojZaduzenja"/></p>
                <p>racunPrimaoca: <xsl:value-of select="nalog/racunPrimaoca"/></p>
                <p>pozivNaBrojOdobrenja: <xsl:value-of select="nalog/pozivNaBrojOdobrenja"/></p>
                <p>iznos: <xsl:value-of select="nalog/iznos"/></p>
                <p>oznakaValute: <xsl:value-of select="nalog/oznakaValute"/></p>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>