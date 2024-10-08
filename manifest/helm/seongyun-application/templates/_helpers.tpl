{{- define "seongyun-application.labels" -}}
{{ include "seongyun-application.selectorLabels" . }}
{{- end }}

{{- define "seongyun-application.selectorLabels" -}}
instance: {{ .Values.application }}-{{ .Values.profile }}
{{- end }}
