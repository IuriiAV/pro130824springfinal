FROM ubuntu:latest
LABEL authors="iurii"

ENTRYPOINT ["top", "-b"]