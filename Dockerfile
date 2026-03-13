FROM maven:3.9-eclipse-temurin-21

WORKDIR /app

# Install Chrome (fixed for Ubuntu noble)
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        wget \
        unzip \
        curl \
        gnupg \
        ca-certificates \
        fonts-liberation \
        libasound2t64 \
        libatk-bridge2.0-0 \
        libatk1.0-0 \
        libcups2 \
        libdbus-1-3 \
        libdrm2 \
        libgbm1 \
        libgtk-3-0 \
        libnspr4 \
        libnss3 \
        libu2f-udev \
        libvulkan1 \
        libx11-6 \
        libx11-xcb1 \
        libxcb1 \
        libxcomposite1 \
        libxdamage1 \
        libxext6 \
        libxfixes3 \
        libxkbcommon0 \
        libxrandr2 \
        xdg-utils && \
    wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt-get install -y ./google-chrome-stable_current_amd64.deb && \
    rm google-chrome-stable_current_amd64.deb && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV BROWSER=chrome
ENV HEADLESS=true

COPY pom.xml .
COPY src ./src
COPY testng.xml .

RUN mvn -B -q -e -DskipTests dependency:resolve

RUN mvn clean package -DskipTests

CMD ["mvn","test","allure:report"]